package org.cloudburstmc.server.block.behavior;

import org.cloudburstmc.server.block.BlockIds;
import org.cloudburstmc.server.item.behavior.ItemTool;

public class BlockBehaviorButtonWooden extends BlockBehaviorButton {

    public BlockBehaviorButtonWooden() {
        super(BlockIds.WOODEN_BUTTON);
    }

    @Override
    public int getToolType() {
        return ItemTool.TYPE_AXE;
    }
}
