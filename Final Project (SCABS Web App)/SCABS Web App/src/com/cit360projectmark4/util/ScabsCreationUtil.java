package com.cit360projectmark4.util;

import com.cit360projectmark4.dao.BaseDao;
import com.cit360projectmark4.dao.BaseDaoImpl;
import com.cit360projectmark4.pojo.ScabsEntity;
import com.cit360projectmark4.pojo.TempScab;

import java.util.ArrayList;
import java.util.Random;

public class ScabsCreationUtil {
    ArrayList<TempScab> scabs = new ArrayList<>();

    public ArrayList<TempScab> getScabs(int calories) {
        int golden_chance = goldenRealmCalculator(calories);
        int normal_chance = (100 - golden_chance)/2;

        for (int i = 0; i < 3; i++) {
            scabs.add(generateScab(normal_chance));
        }

        return scabs;
    }

    private TempScab generateScab(int nchance){
        Random rand = new Random();
        int scab_chance = rand.nextInt((100 - 1) + 1) + 1;
        int scab_pick = rand.nextInt((3 - 1) + 1) + 1;

        BaseDao baseDao = new BaseDaoImpl();
        ScabsEntity foundScab = baseDao.getScab(scab_pick);
        TempScab scab = new TempScab();

        //Determines wither Scab is Golden, Honored, or Normal
        if (scab_chance > (nchance*2)) {

            scab.setName(foundScab.getScabName());
            scab.setStr(foundScab.getDefaultStr()+15);
            scab.setLuck(foundScab.getDefaultLuck()+15);

        } else if (scab_chance > nchance) {

            scab.setName(foundScab.getScabName());
            scab.setStr(foundScab.getDefaultStr()+2);
            scab.setLuck(foundScab.getDefaultLuck()-2);

        } else {

            scab.setName(foundScab.getScabName());
            scab.setStr(foundScab.getDefaultStr()-15);
            scab.setLuck(foundScab.getDefaultLuck()-15);

        }

        return scab;
    }

    private int goldenRealmCalculator(int calories) {
        double num1 = ((calories * 2) * .001);
        double num2 = Math.atan(1.5574 * num1);
        double num3 = num2 * 25;
        int result = (int) num3;
        return result;
    }
}
