package com.uniyaz.eticaret.entity;

import java.io.Serializable;
import java.util.Date;

public abstract class BaseEntity implements Serializable {

    public abstract Long getId();




    public abstract boolean equals(Object o);


    public abstract int hashCode();
}
