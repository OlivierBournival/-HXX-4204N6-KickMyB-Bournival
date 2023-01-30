package com.example.apptp.model;
import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Tache {
    public String nom;
    public int PourcentageAcomplicement; //metre valeur entre 0 et 100
    public   Duration tempEcouler ;
    public java.time.LocalDateTime dateLimite ;
}
