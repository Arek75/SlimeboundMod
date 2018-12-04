 package slimebound.cards;


import basemod.abstracts.CustomCard;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.NextTurnBlockPower;
import com.megacrit.cardcrawl.powers.StrengthPower;
import com.megacrit.cardcrawl.powers.ThornsPower;
import slimebound.SlimeboundMod;
import slimebound.powers.PotencyPower;


 public class Collect extends CustomCard
 {
   public static final String ID = "Collect";
       public static final String NAME;
       public static final String DESCRIPTION;
    public static String UPGRADED_DESCRIPTION;
   public static final String IMG_PATH = "cards/collect.png";

   private static final CardType TYPE = CardType.SKILL;
   private static final CardRarity RARITY = CardRarity.SPECIAL;
   private static final CardTarget TARGET = CardTarget.SELF;
                    private static final CardStrings cardStrings;

   private static final int COST = 1;
   private static final int BLOCK = 5;
   private static final int UPGRADE_BONUS = 3;

   public Collect()
   {
     super(ID, NAME, SlimeboundMod.getResourcePath(IMG_PATH), COST, DESCRIPTION, TYPE, CardColor.COLORLESS, RARITY, TARGET);


     this.baseBlock = 9;
            this.magicNumber = this.baseMagicNumber = 1;

    this.exhaust = true;
    this.isEthereal = true;
   }

   public void use(AbstractPlayer p, AbstractMonster m)
   {
     AbstractDungeon.actionManager.addToBottom(new com.megacrit.cardcrawl.actions.common.GainBlockAction(p, p, this.block));
             AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new StrengthPower(p, this.magicNumber), this.magicNumber ));
            AbstractDungeon.actionManager.addToBottom(new ApplyPowerAction(p, p, new PotencyPower(p, p, this.magicNumber), this.magicNumber));
   }

   public AbstractCard makeCopy()
   {
     return new Collect();
   }

   public void upgrade()
   {
     if (!this.upgraded)
     {
       upgradeName();
       upgradeBlock(4);
     }
   }

    static {
        cardStrings = CardCrawlGame.languagePack.getCardStrings(ID);
        NAME = cardStrings.NAME;
        DESCRIPTION = cardStrings.DESCRIPTION;
        UPGRADED_DESCRIPTION = cardStrings.UPGRADE_DESCRIPTION;
    }
 }


