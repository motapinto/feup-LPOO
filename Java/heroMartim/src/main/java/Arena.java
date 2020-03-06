import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Arena {
    private int width;
    private int height;
    private int score;
    private Hero hero;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
        this.score = 0;

        this.hero = new Hero(5, 1);
        this.walls = this.createWalls();
        this.coins = this.createCoins();
        this.monsters = this.createMonsters();
    }

    // Draws the arena (hero + walls)
    public void draw(TextGraphics graphics) {

        graphics.setBackgroundColor(TextColor.Factory.fromString("#458273"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        this.hero.draw(graphics);

        for (Wall wall : this.walls) {
            wall.draw(graphics);
        }

        for (Coin coin : this.coins) {
            coin.draw(graphics);
        }

        for (Monster monster : this.monsters) {
            monster.draw(graphics);
        }
    }

    // Processes the input key
    public boolean processKey(KeyStroke key){
        switch (key.getKeyType()) {
            case ArrowUp:
                updateArena(hero.moveUp());
                break;
            case ArrowDown:
                updateArena(hero.moveDown());
                break;
            case ArrowLeft:
                updateArena(hero.moveLeft());
                break;
            case ArrowRight:
                updateArena(hero.moveRight());
                break;
            case EOF:
                System.out.println("Score: " + this.score);
                return false;
        }
        return true;
    }

    // Checks if the hero can move in the screen -? é preciso mudar pro causa das colisoes das paredes?
    private boolean canElementMove(Position position) {
        for(Wall wall : walls) {
            if (wall.getPosition().equals(position)){
                return false;
            }
        }

        return true;
    }

    // Changes the hero position
    public void updateArena(Position position) {
        if(canElementMove(position)) {
            this.hero.setPosition(position);
            this.retrieveCoins();
        }

        this.moveMonsters();
        if(this.verifyMonsterCollisions()) {
            // ...
        }
    }

    // Creates the Walls objects
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList();

        try {
            File level = new File("C:\\Users\\Martim\\Desktop\\feup-LPOO\\Java\\hero\\assets\\level.txt");
            Scanner reader = new Scanner(level);
            int line = 0;
            while (reader.hasNext()) {
                String data = reader.nextLine();
                for (int i = 0; i < data.length(); i++){
                    char c = data.charAt(i);
                    if(c == 'x') {
                        walls.add(new Wall(i, line));
                    }
                }
                line ++;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return walls;
    }

    // Creates the monster in a random position
    private List<Monster> createMonsters() {
        Random random = new Random();
        List<Monster> monsters = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            while(true) {
                int x = random.nextInt(width - 2) + 1;
                int y = random.nextInt(height - 2) + 1;
                if(x != this.hero.getPosition().getX() && y != this.hero.getPosition().getY()
                    /*&& !this.coins.contains(new Coin(x, y))*/) {
                    monsters.add(new Monster(x, y));
                    break;
                }
            }
        }
        return monsters;
    }

    // Changes the monsters position
    public void moveMonsters() {
        for (Monster monster : monsters) {
            Position newPosition = monster.move();
            if (canElementMove(newPosition)) {
                monster.setPosition(newPosition);
            }
        }
    }

    // Detects monster collisions with the hero
    public boolean verifyMonsterCollisions() {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(hero.getPosition())) {
                return true;
            }

        return false;
    }

    // Creates the Coins objects in random positions
    private List<Coin> createCoins() {
        Random random = new Random();
        List<Coin> coins = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            while(true) {
                int x = random.nextInt(width - 2) + 1;
                int y = random.nextInt(height - 2) + 1;
                if(x != this.hero.getPosition().getX() && y != this.hero.getPosition().getY()
                        /*&& !this.coins.contains(new Coin(x, y))*/) {
                    coins.add(new Coin(x, y));
                    break;
                }
            }
        }
        return coins;
    }

    // Check if hero landed on any coin, and if so, removes it and updates score
    public List<Coin> retrieveCoins() {
        List<Coin> coinList = this.coins;

        for(Coin coin : this.coins) {
            if(coin.getPosition().equals(this.hero.getPosition())) {
                this.score ++;
                coinList.remove(coin);
                break;
            }
        }
        return coinList;
    }
}
