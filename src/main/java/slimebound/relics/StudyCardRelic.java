package slimebound.relics;

import basemod.abstracts.CustomRelic;
import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.common.RelicAboveCreatureAction;
import com.megacrit.cardcrawl.cards.colorless.Shiv;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.orbs.AbstractOrb;
import com.megacrit.cardcrawl.relics.AbstractRelic;
import slimebound.actions.RandomStudyCardAction;
import slimebound.vfx.TinyHatParticle;

public class StudyCardRelic extends CustomRelic {
    public static final String ID = "StudyCardRelic";
    public static final String IMG_PATH = "relics/tinybowlerhat.png";
    public static final String OUTLINE_IMG_PATH = "relics/tinybowlerhatOutline.png";
    private static final int HP_PER_CARD = 1;

    public StudyCardRelic() {
        super(ID, new Texture(slimebound.SlimeboundMod.getResourcePath(IMG_PATH)),new Texture(slimebound.SlimeboundMod.getResourcePath(OUTLINE_IMG_PATH)),
                RelicTier.BOSS, LandingSound.MAGICAL);
    }

    @Override
    public String getUpdatedDescription() {
        return this.DESCRIPTIONS[0];
    }

    @Override
    public void atBattleStartPreDraw() {
        AbstractDungeon.actionManager.addToBottom(new VFXAction(new TinyHatParticle(AbstractDungeon.player)));
        this.flash();

        AbstractDungeon.actionManager.addToBottom(new RelicAboveCreatureAction(AbstractDungeon.player, this));
       AbstractDungeon.actionManager.addToBottom(new RandomStudyCardAction(false));
    }



    @Override
    public AbstractRelic makeCopy() {
        return new StudyCardRelic();
    }

}