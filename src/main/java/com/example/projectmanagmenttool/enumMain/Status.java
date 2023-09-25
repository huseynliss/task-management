package com.example.projectmanagmenttool.enumMain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Status {

    TO_DO("To Do"),

    In_Progress(  "In Progress"),

    In_Review(  "Needs Review"),

    Done(  "Done");

    private final String message;
}