 package slimebound.cards;


import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.animations.VFXAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.vfx.combat.CleaveEffect;
import slimebound.SlimeboundMod;
import slimebound.patches.AbstractCardEnum;
import slimebound.powers.StunnedPower;
import slimebound.powers.TackleBuffPower;



 public class SlimeHyperBeam extends CustomCard
 {
       public static final String ID = "SlimeHyperBeam";
       public static final String NAME;
       public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
       public static final String IMG_PATH = "cards/hyper_beam.png";
       private static final CardType TYPE = CardType.ATTACK;
       private static final CardRarity RARITY = CardRarity.SPECIAL;
       private static final CardTarget TARGET = CardTarget.ALL_ENEMY;

    private static final CardStrings cardStrings;
       private static final int COST = 2;
       private static final int POWER = 6;
       private static final int UPGRADE_BONUS = 3;


    public SlimeHyperBeam()
     {

        super(ID, NAME, SlimeboundMod.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, CardColor.COLORLESS, RARITY, TARGET);


        this.baseDamage = 24;
        this.magicNumber = this.baseMagicNumber = 1;
             this.isMultiDamage = true;
        this.exhaust = true;
        this.isEthereal = true;


    }



    public void use(AbstractPlayer p, AbstractMonster m)
     {


        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.utility.SFXAction("ATTACK_HEAVY"));
        AbstractDungeon.actionManager.addToBottom(new VFXAction(p, new com.megacrit.cardcrawl.vfx.combat.MindblastEffect(p.dialogX, p.dialogY, p.flipHorizontal), 0.1F));
        AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.DamageAllEnemiesAction(p, this.multiDamage, this.damageTypeForTurn, AbstractGameAction.AttackEffect.NONE));



    }








    public AbstractCard makeCopy()
     {

        return new SlimeHyperBeam();

    }



    public void upgrade()
     {

        if (!this.upgraded)
             {

            upgradeName();
            upgradeDamage(10);


        }

    }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;

    }
}


