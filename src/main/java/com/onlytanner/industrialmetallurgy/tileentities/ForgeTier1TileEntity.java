package com.onlytanner.industrialmetallurgy.tileentities;

import com.onlytanner.industrialmetallurgy.blocks.ForgeTier1Block;
import com.onlytanner.industrialmetallurgy.containers.ForgeTier1Container;
import com.onlytanner.industrialmetallurgy.init.ModTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nullable;

public class ForgeTier1TileEntity extends ModTileEntityBase implements ITickableTileEntity, ISidedInventory {

    private final int INVENTORY_SIZE = 6;
    public int x, y, z, tick;
    private boolean initialized = false;
    private NonNullList<ItemStack> invContents = NonNullList.withSize(INVENTORY_SIZE, ItemStack.EMPTY);
    protected int numPlayerUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    public ForgeTier1TileEntity() {
        this(ModTileEntityTypes.FORGE_TIER1.get());
    }

    private ForgeTier1TileEntity(final TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.forge_tier1");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new ForgeTier1Container(id, player, this);
    }

    @Override
    public NonNullList<ItemStack> getItems() {
        return this.invContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.invContents = itemsIn;
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.invContents);
        }
        return compound;
    }

    @Override
    public void func_230337_a_(BlockState state, CompoundNBT compound)  {
        super.checkLootAndRead(compound);
        this.invContents = NonNullList.withSize(this.INVENTORY_SIZE, ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.invContents);
        }
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.numPlayerUsing = type;
            return true;
        }
        else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.numPlayerUsing < 0) {
                this.numPlayerUsing = 0;
            }
            this.numPlayerUsing++;
            this.openOrClose();
        }
    }

    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            this.numPlayerUsing--;
            this.openOrClose();
        }
    }

    protected void openOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof ForgeTier1Block) {
            this.world.addBlockEvent(this.pos, block, 1, this.numPlayerUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }

    public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState state = reader.getBlockState(pos);
        if (state.hasTileEntity()) {
            TileEntity te = reader.getTileEntity(pos);
            if (te instanceof ForgeTier1TileEntity) {
                return ((ForgeTier1TileEntity) te).numPlayerUsing;
            }
        }
        return 0;
    }

    public static void swapContents(ForgeTier1TileEntity te, ForgeTier1TileEntity otherTe) {
        NonNullList<ItemStack> list = te.getItems();
        te.setItems(otherTe.getItems());
        otherTe.setItems(list);
    }

    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }

    @Nullable
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> cap, @Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }

    @Override
    public void remove() {
        super.remove();
        if (itemHandler != null) {
            itemHandler.invalidate();
            itemHandler = null;
        }
    }

    @Override
    public void tick() {
        if (!initialized)
            init();
        tick++;
        // on tick expiration, call execute()
    }

    private void execute() {

    }

    private void init() {
        initialized = true;
        x = this.pos.getX() - 1;
        y = this.pos.getY() - 1;
        z = this.pos.getZ() - 1;
        tick = 0;
    }

    @Override
    public int getSizeInventory() {
        return INVENTORY_SIZE;
    }

    @Override
    public int[] getSlotsForFace(Direction side) {
        return new int[0];
    }

    @Override
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        return false;
    }

    @Override
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        return false;
    }
}
