package cn.nukkit.block;

import cn.nukkit.event.block.BlockFadeEvent;
import cn.nukkit.item.Item;
import cn.nukkit.item.ItemTool;
import cn.nukkit.level.Level;
import cn.nukkit.player.Player;
import cn.nukkit.utils.BlockColor;
import cn.nukkit.utils.Identifier;

import static cn.nukkit.block.BlockIds.AIR;
import static cn.nukkit.block.BlockIds.WATER;

/**
 * author: MagicDroidX
 * Nukkit Project
 */
public class BlockIce extends BlockTransparent {

    public BlockIce(Identifier id) {
        super(id);
    }

    @Override
    public double getResistance() {
        return 2.5;
    }

    @Override
    public double getHardness() {
        return 0.5;
    }

    @Override
    public double getFrictionFactor() {
        return 0.98;
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_PICKAXE;
    }

    @Override
    public boolean onBreak(Item item, Player player) {
        if (player.getGamemode() == Player.CREATIVE) {
            return this.getLevel().setBlock(this, Block.get(AIR), true);
        }

        if (down().isSolid()) {
            return this.getLevel().setBlock(this, Block.get(WATER), true);
        } else {
            return this.getLevel().setBlock(this, Block.get(AIR), true);
        }
    }

    @Override
    public int onUpdate(int type) {
        if (type == Level.BLOCK_UPDATE_RANDOM) {
            if (this.getLevel().getBlockLightAt(this.x, this.y, this.z) >= 12) {
                BlockFadeEvent event = new BlockFadeEvent(this, get(WATER));
                level.getServer().getPluginManager().callEvent(event);
                if (!event.isCancelled()) {
                    level.setBlock(this, event.getNewState(), true);
                }
                return Level.BLOCK_UPDATE_NORMAL;
            }
        }
        return 0;
    }

    @Override
    public Item[] getDrops(Item item) {
        return new Item[0];
    }

    @Override
    public BlockColor getColor() {
        return BlockColor.ICE_BLOCK_COLOR;
    }

    @Override
    public boolean canSilkTouch() {
        return true;
    }
}
