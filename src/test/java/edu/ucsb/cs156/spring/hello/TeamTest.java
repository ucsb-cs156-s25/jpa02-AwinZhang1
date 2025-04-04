package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_returns_true_for_same_object(){
        assertEquals(team,team);
    }

    @Test
    public void equals_returns_false_for_different_classes(){
        
        assertEquals(team.equals("test"),false);
    }

    @Test
    public void equals_returns_true_for_same_name_and_members(){
        Team a = new Team("test-team");
        a.addMember("Awin");
        team.addMember("Awin");
        assertEquals(team.equals(a),true);
    }

    @Test
    public void equals_returns_false_for_diff_name_same_members(){
        Team a = new Team("diff-team");
        a.addMember("Awin");
        team.addMember("Awin");
        assertEquals(team.equals(a),false);
    }

    @Test
    public void equals_returns_false_for_same_name_diff_members(){
        Team a = new Team("test-team");
        a.addMember("Awin");
        team.addMember("NotAwin");
        assertEquals(team.equals(a),false);
    }

    @Test
    public void hashCode_returns_correct_value(){
        int result=team.hashCode();
        int expectedResult=-1226298695;
        assertEquals(result, expectedResult);
    }
}
