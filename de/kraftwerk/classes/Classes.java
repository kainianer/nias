/*
 * Copyright 2013 by Kraftwerk Productions
 * Do not distribute!
 */
package de.kraftwerk.classes;

import de.kraftwerk.item.Item.Stats;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kainianer
 */
public enum Classes {

    HUNTER(Stats.ATTACKSPEED, Stats.ENDURANCE),
    MAGE(Stats.INTELLIGENCE, Stats.WISDOM),
    WARRIOR(Stats.STRENGTH, Stats.RESISTANCE);

    private final List<Stats> statList;

    private Classes(Stats s1, Stats s2) {
        this.statList = new ArrayList<>();
        this.statList.add(s1);
        this.statList.add(s2);
        this.statList.add(Stats.VITALITY);
        this.statList.add(Stats.RUNSPEED);
        this.statList.add(Stats.ATTACKSPEED);
    }

    public List<Stats> getClassStats() {
        return this.statList;
    }
    
}
