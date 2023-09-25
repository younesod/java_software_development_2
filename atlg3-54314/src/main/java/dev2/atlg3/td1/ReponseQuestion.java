/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev2.atlg3.td1;

/**
 *
 * @author zheln
 */
public class ReponseQuestion {
    
   /*
    Q1)
    1.
        Il affiche l'objet p , la valeur x de l'objet p et sa couleur
        (3.0, 6.0) - FF0000FF,,
        x: 3.0
        color : FF0000FF
    
    2.
        la ligne 10 pose problème car on demande une méthode que Point n'a pas
        Il y aura toujours une erreur car le construceur de Point ne prend en paramètre que 2 arguments 2 double qui plus est
    
    3.
        Non car on ne peut pas convertir un objet de type ColoredPoint en Point
    
    4.
        Non car les attributs x et y sont privés dans la classe Point 
    
    5.
        Il y aura une héritance cyclique , Point qui hérite de ColoredPoint - ColoredPoint qui hérite de Point
    6.
        Si l'on déclare final la class ColoredPoint qui est censé hériter des attributs et méthodes de Point ne pourra pas avoir accès
      
    
    
    Q2)
    
     1.
        Oui car toutes les classes héritent de la classe Object
    
    2.
        Oui même chose qu'au dessus
    
    3.
        Oui, elle est défini dans sa propre classe
        On appelle le hashcode sur l"objet ColoredPoint car toute classe possède la méthode hashcode qui permet de génerer un nombre à un objet de la classe
    
    4.
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.color;
        return hash;
    }
    
    
    Q3)
    
    1.
        L'appel de super doit être le premier bloc 
    
    2.  
        Le constructeur Point dans la classe Point requière 2 arguments tandis qu'on a aucun argument
        Cette ligne sert à appeler les attributs de la classe Parent
    
    3.
        L'erreur est pareil
    
    Q4)
     
    1.
        constructor of A
        constructor of B
        constructor of C
    
    2.
        constructor of A
        constructor of B
    
    3.
        constructor of A
        constructor of B
        constructor of C
    
    4.
        toString ()
        getClass ()
        equals (Object o)
        hashCode () 
    
    Q5)
    
     1.
        (0.0, 0.0) - not pinned
        (1.0, 1.0) - pinned
    
    2.
        la méthode de PinnablePoint
    
    3.
        unreported exception Exception; must be caught or declared to be thrown
    */
}
