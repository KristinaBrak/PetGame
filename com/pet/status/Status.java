package com.pet.status;

import java.io.Serializable;

public interface Status extends Serializable {

    void increase(int value);

    void decrease(int value);

    int getValue();

    StatusName getName();

    void setName(StatusName name);

}