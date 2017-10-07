package com.example.baehyeonbin.retrofitexample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by 이건호 on 2017-10-07.
 */
@Getter
@Setter
@ToString
@AllArgsConstructor(suppressConstructorProperties = true)
@NoArgsConstructor
public class TestRepo {
    private String name;
    private int number;
}
