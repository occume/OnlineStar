package org.d3.wx.vo;

public class Card {

	private String id;
	private String name;
	private String type;
	private String rarity;
	private String faction;
	private String flavor;
	private String playerClass;
	private String artist;
	private String text;
	private String howToGetGold;
	private String howToGet;
	private String race;
	private String inPlayText;
	private int		health;
	private int		attack;
	private int		cost;
	private int		durability;
	private boolean collectible;
	private boolean elite;

	public Card(){}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getFaction() {
		return faction;
	}
	public void setFaction(String faction) {
		this.faction = faction;
	}
	public String getFlavor() {
		return flavor;
	}
	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getPlayerClass() {
		return playerClass;
	}

	public void setPlayerClass(String playerClass) {
		this.playerClass = playerClass;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public boolean isCollectible() {
		return collectible;
	}

	public void setCollectible(boolean collectible) {
		this.collectible = collectible;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getHowToGetGold() {
		return howToGetGold;
	}

	public void setHowToGetGold(String howToGetGold) {
		this.howToGetGold = howToGetGold;
	}

	public String getHowToGet() {
		return howToGet;
	}

	public void setHowToGet(String howToGet) {
		this.howToGet = howToGet;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public boolean isElite() {
		return elite;
	}

	public void setElite(boolean elite) {
		this.elite = elite;
	}

	public String getInPlayText() {
		return inPlayText;
	}

	public void setInPlayText(String inPlayText) {
		this.inPlayText = inPlayText;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", name=" + name + ", type=" + type
				+ ", rarity=" + rarity + ", faction=" + faction + ", flavor="
				+ flavor + ", playerClass=" + playerClass + ", artist="
				+ artist + ", text=" + text + ", howToGetGold=" + howToGetGold
				+ ", howToGet=" + howToGet + ", race=" + race + ", health="
				+ health + ", attack=" + attack + ", cost=" + cost
				+ ", durability=" + durability + ", collectible=" + collectible
				+ ", elite=" + elite + "]";
	}

}
