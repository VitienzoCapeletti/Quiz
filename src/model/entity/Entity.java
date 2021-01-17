package model.entity;

public interface Entity<T> {

    T fromFile(String[] input);

    String[] toFile();



}
