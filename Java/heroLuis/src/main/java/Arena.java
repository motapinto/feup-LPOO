import element.Element;
import element.position.Position;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int maxCoins;
    private Hero hero;
    private int height;
    private int width;

    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private List<Life> lives;
    private List<Coin> score;

    public Arena(int width, int height, int lives, int maxCoins, int monsters) {
        this.height = height;
        this.width = width;
        this.maxCoins = maxCoins;

        this.hero = new Hero(10, 10);
        this.walls = createWalls();
        this.coins = createCoins(maxCoins);
        this.monsters = createMonsters(monsters);
        this.score = new ArrayList<>();
        this.lives = this.createLives(lives);
    }

    public boolean processMovement(Movement movement) {
        moveElement(this.hero, this.hero.move(movement));

        // Verify if the player moved into a monster
        if(this.verifyMonsterCollisions())
            return true;

        this.moveMonsters();
        this.retrieveCoins();
        // Verify is a monster moved into the player
        return this.verifyMonsterCollisions();
    }

    public List<Element> getElements(){
        List<Element> elements = new ArrayList<>();

        elements.addAll(this.walls);
        elements.addAll(this.coins);
        elements.addAll(this.monsters);
        elements.addAll(this.lives);
        elements.addAll(this.score);
        elements.add(this.hero);

        return elements;
    }

    private void moveElement(Element element, Position position) {
        if (this.canElementMove(position))
            element.setPosition(position);
    }

    private void moveMonsters() {
        Random rand = new Random();

        for (Monster monster: this.monsters) {
            this.moveElement(monster, monster.move(Movement.values()[rand.nextInt(4)]));
        }
    }

    private boolean verifyMonsterCollisions() {
        for (Monster monster: this.monsters) {
            if(this.hero.getPosition().equals(monster.getPosition())) {
                this.lives.remove(this.lives.size() - 1);
                if(this.lives.size() == 0) return true;
            }
        }
        return false;
    }

    private void retrieveCoins(){
        Coin[] coins = this.coins.toArray(new Coin[0]);
        int size = this.coins.size();

        for (int i = 0; i < size; i++) {
            if(coins[i].getPosition().equals(this.hero.getPosition())){
                coins[i].setPosition(new Position(this.score.size(), 22));

                this.score.add(coins[i]);
                this.coins.remove(i);
            }
        }

        if(this.coins.size() == 0){
            this.coins = this.createCoins(this.maxCoins);
        }

    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

    private List<Monster> createMonsters(int number) {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Position position;
            boolean unique;

            do {
                position = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                unique = true;

                if(position.equals(hero.getPosition())) {
                    unique = false;
                    continue;
                }
                for (Monster monster: monsters){
                    if(position.equals(monster.getPosition())) {
                        unique = false;
                        break;
                    }
                }
                for (Coin coin: this.coins){
                    if(position.equals(coin.getPosition())) {
                        unique = false;
                        break;
                    }
                }

            } while (!unique);

            monsters.add(new Monster(position));
        }
        return monsters;
    }

    private List<Coin> createCoins(int number) {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            Position position;
            boolean unique;

            do {
                position = new Position(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                unique = true;

                if(position.equals(hero.getPosition())) {
                    unique = false;
                    continue;
                }
                for (Coin coin: coins){
                    if(position.equals(coin.getPosition())) {
                        unique = false;
                        break;
                    }
                }

            } while (!unique);

            coins.add(new Coin(position));
        }
        return coins;
    }

    private List<Life> createLives(int lives) {
        List<Life> livesList = new ArrayList<>();

        for (int i = 0; i < lives; i++) {
            livesList.add(new Life(i, 21));
        }

        return livesList;
    }

    private boolean canElementMove(Position position){
        int x = position.getX();
        int y = position.getY();

        for (Wall wall: walls){
            if (position.equals(wall.getPosition())) {
                return false;
            }
        }

        return x > 0 && x < this.width && y > 0 && y < this.height;
    }

}
