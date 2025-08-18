package com.kunal.entity;

import com.kunal.enums.Gender;
import com.kunal.enums.PetType;

public abstract class Pet extends Base{

    private String name;

    private Gender gender;

    private PetType type;

    private Owner owner;

}
