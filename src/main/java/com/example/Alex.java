package com.example;

import java.util.List;

public class Alex extends Lion{

    public Alex(Feline feline) throws Exception {
        super("Самец", feline);

    }
    public List<String> getFriends(){ //возвращает список имён его друзей
        return List.of("зебра Марти", "бегемотиха Глория", "жираф Мелман");
    }

    public String getPlaceOfLiving() { //где живет
        return "Нью-Йоркский зоопарк";
    }
    @Override
    public int getKittens(){ //у Алекса нет котят, поэтому просто 0.
        return 0;
    }
}
