package com.example.watopoly.util;

import com.example.watopoly.model.ChanceCardStrategy.ChanceStrategy;
import com.example.watopoly.model.ChanceCardStrategy.GainLoseMoneyCard;
import com.example.watopoly.model.ChanceCardStrategy.GetOutOfJailCard;
import com.example.watopoly.model.ChanceCardStrategy.GoToJailCard;
import com.example.watopoly.model.ChanceCardStrategy.MoveRelativeDistanceCard;
import com.example.watopoly.model.ChanceCardStrategy.MoveToTileCard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public final class ChanceCards {

    private static ArrayList<ChanceStrategy> chanceCards = new ArrayList<>(Arrays.asList(
        new GainLoseMoneyCard("It's time to be fees arranged.", "Next school term is on the horizon. It's time to pay your tuition on Quest! Lose $200", -200),
        new GainLoseMoneyCard("You won coop student of the year!", "Congrats on your achievement! You get a picture with Feridun and a $20 award.", 20),
        new GainLoseMoneyCard("You got stuck with a bad landlord.", "Pay $50 for repairs.", -50),
        new GetOutOfJailCard("A golden goose visited you in your dreams.", "He gave you a get out of jail free card. Sweet!"),
        new GoToJailCard("You have been caught violating policy 71.", "Go to jail! (tsk tsk)"),
        new MoveRelativeDistanceCard("During your walk it starts to rain.", "You start to do a little jog. Move 2 spaces forward.", 2),
        new GetOutOfJailCard("You saw Feridun on campus and he shook your hand.", "What a day to remember. Collect a get out of jail free card"),
        new GainLoseMoneyCard("You were ranked first in your class!", "Very impressive! The school gave you a scholarship for 150", 150),
        new MoveToTileCard("You've sat in a concrete MC all day and need a change.", "Move to the very scenic M3 to change up the mood.", BoardTiles.getBuildingTileByName("M3")),
        new GainLoseMoneyCard("After 5 years of University you've finally collected enough points at the UW Store", "Who would've thought. You redeemed them and got $50 back.", 50),
        new MoveRelativeDistanceCard("You realized its Tuesday today.", "Looks like you have a PD assignment to do tonight. Move back 6 spaces.", -6),
        new GainLoseMoneyCard("You found a PDF of a textbook you needed for that one class.", "The internet is beautiful. You return the hard copy and get back $100", 100),
        new MoveRelativeDistanceCard("A mysterious grey haired man is standing in front of you to ask you if you know about your dental plan", "You really don't want to talk to him right now. Move 3 spaces", 3),
        new GainLoseMoneyCard("Congrats! Your intramural frisbee team finished the season in first place!", "Way to go! Collect 50", 50),
        new MoveRelativeDistanceCard("An unprovoked goose is chasing you for some reason.", "Your flight or fight response activates and you start running. Move 5 spaces", 5),
        new GainLoseMoneyCard("You got food poisoning from UW food services.", "It happens to the best of us. Pay $50 to visit the doctor.", -50),
        new GainLoseMoneyCard("You just got a grant from OSAP. How cool!", "Collect 200", 200),
        new MoveToTileCard("You have an intramural volleyball game tonight.", "Good luck sport! Move to PAC.", BoardTiles.getBuildingTileByName("PAC")),
        new GainLoseMoneyCard("You qualified for a University funded bursary!", "Collect 200.", 200),
        new GainLoseMoneyCard("It snowed yesterday and now the campus sidewalks are so icy it's criminal.", "You wiped out and fell hard. The school gave you $100 for your troubles", 100),
        new GetOutOfJailCard("You were the only person who went to office hours.", "You've earned a Get Out of Jail Free Card!"),
        new MoveToTileCard("It's that time of year. You desperately need to take a Linkedin picture.", "Move to E7 to take a bridge picture", BoardTiles.getBuildingTileByName("E7")),
        new GainLoseMoneyCard("You got a refund for your WUSA dental/health plan.", "Collect 100", 100),
        new GoToJailCard("The librarian has caught you red handed whispering in silent study!", "You get aggressively shushed and sent to jail. Literally how could you."),
        new MoveToTileCard("You hear they're giving out free food in the Arts Quad.", "Of course you'll be the first one in line! Move to ML", BoardTiles.getBuildingTileByName("ML")),
        new MoveToTileCard("You have an exam tomorrow and its looking like an all nighter.", "Move to DC", BoardTiles.getBuildingTileByName("DC")),
        new MoveRelativeDistanceCard("A goose on the sidewalk is staring you down.", "Move back 3 spaces to avoid eminent danger", -3),
        new GainLoseMoneyCard("You lost your WatCard on the bus.", "Pay $50 to replace it.", -50),
        new GainLoseMoneyCard("To your dismay, C&D does not accept meal plan money for some reason.", "Pay $20 for that Jamaican Patty", 20),
        new GoToJailCard("You didn't know that one section of QNC was only for grad students.", "The second you took a step onto the premise, security has you removed and put in jail"),
        new MoveToTileCard("You had Lazeez for dinner and you're beginning to feel it.", "Good luck with that. Move to C&D to pick up some Peptobismol", BoardTiles.getBuildingTileByName("Math C&D")),
        new GainLoseMoneyCard("Give into your bubble tea addiction.", "You have no choice but to enjoy a delicious milk tea from your favourite bubble tea shop. Spend $20", 20),
        new GainLoseMoneyCard("Geese have stolen your lunch money.", "On your way to 8:30 class some geese attacked you on V1 green and took your money. Lose $20", -20)));

    public static ArrayList<ChanceStrategy> getAllChanceCards(){
        return chanceCards;
    }
    public static ChanceStrategy drawRandomChanceCard(){
        Random rand = new Random();
        return chanceCards.get(rand.nextInt(chanceCards.size()));
    }
}

