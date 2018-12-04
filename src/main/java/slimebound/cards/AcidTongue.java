 package slimebound.cards;


import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import slimebound.SlimeboundMod;
import slimebound.patches.AbstractCardEnum;
import slimebound.powers.AcidTonguePower;
import slimebound.powers.GluttonyPower;
import slimebound.powers.GluttonyPowerUpgraded;


 public class AcidTongue extends CustomCard
         {
       public static final String ID = "AcidTongue";

                private static final CardStrings cardStrings;
                public static final String NAME;
                public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
       public static final String IMG_PATH = "cards/acidtongue.png";
       private static final CardType TYPE = CardType.POWER;
       private static final CardRarity RARITY = CardRarity.RARE;
       private static final CardTarget TARGET = CardTarget.SELF;

       private static final int COST = 1;

       private static int upgradedamount = 1;

       public AcidTongue()
       {
             super(ID, NAME, SlimeboundMod.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, AbstractCardEnum.SLIMEBOUND, RARITY, TARGET);
                    this.magicNumber = this.baseMagicNumber = 1;


           }

       public void use(AbstractPlayer p, AbstractMonster m)
     {AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new AcidTonguePower(p, p, this.magicNumber), this.magicNumber));

        }


       public AbstractCard makeCopy()
       {
             return new AcidTongue();
           }

       public void upgrade()
       {
             if (!this.upgraded)
                 {
                   upgradeName();
            upgradeMagicNumber(1);


                 }
           }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
     }

