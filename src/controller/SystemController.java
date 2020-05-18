package controller;

import controller.commands.CommandInvoker;

import java.util.ArrayList;
import java.util.List;


public class SystemController {

    public static PollingObserver observer = new PollingObserver();
    public static CommandInvoker voter;
    public static List<Memento> savedVoted = new ArrayList<Memento>();
}
