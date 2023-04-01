package com.example.zinform;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ServiceTest {

    private static ZinsService service;

    @Test
    @DisplayName("check if the result list has the right size due to the years")
    void test_1(){
        //Arrange
        service = new ZinsService();
        interestForm zinsForm =new interestForm(5000.0,3,0.5);
        //Act
        List<ZinsJahre> ergebnisseList = service.zinsenBerechnen(zinsForm);
        //Assert
        assertThat(ergebnisseList.size()).isEqualTo(3);
    }
    @Test
    @DisplayName("check if the endgeld has the right result after calculating the zins")
    void test_2(){
        //Arrange
        service = new ZinsService();
        interestForm zinsForm =new interestForm(5000.0,3,0.5);
        //Act
        List<ZinsJahre> ergebnisseList = service.zinsenBerechnen(zinsForm);
        Double endgeld = ergebnisseList.get(2).end();
        //Assert
        assertThat(endgeld).isEqualTo(5075.38);
    }
}
