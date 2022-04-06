package Google;

import java.util.ArrayList;
import java.util.List;

public class Persons {

    private String peopleName;
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Persons() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }


    public void setPokemon(Pokemon pokemon) {
        if (!checkIfPokemonExists(pokemons, pokemon)) {
            this.pokemons.add(pokemon);
        }
    }

    private boolean checkIfPokemonExists(List<Pokemon> pokemons, Pokemon pokemon) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getPokemonName().equals(pokemon.getPokemonName())) {
                return true;
            }
        }
        return false;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setParents(Parent parent) {
        if (!checkIfParentsExists(parents, parent)) {
            this.parents.add(parent);
        }
    }

    private boolean checkIfParentsExists(List<Parent> parents, Parent parent) {
        for (int i = 0; i < parents.size(); i++) {
            if (parents.get(i).getParentName().equals(parent.getParentName())) {
                return true;
            }
        }
        return false;
    }

    public List<Parent> getParents() {
        return parents;
    }


    public void setChildren(Child child) {
        if (!checkIfChildrenExists(children, child)) {
            this.children.add(child);
        }
    }

    private boolean checkIfChildrenExists(List<Child> children, Child child) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getChildName().equals(child.getChildName())) {
                return true;
            }
        }
        return false;
    }

    public List<Child> getChildren() {
        return children;
    }


    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("Company:");
        strBuild.append(System.lineSeparator());
        if (company != null) {
            strBuild.append(company.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Car:");
        strBuild.append(System.lineSeparator());
        if (car != null) {
            strBuild.append(car.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Pokemon:");
        strBuild.append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            strBuild.append(pokemon.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Parents:");
        strBuild.append(System.lineSeparator());
        for (Parent parent : parents) {
            strBuild.append(parent.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Children:");
        strBuild.append(System.lineSeparator());
        for (Child child : children) {
            strBuild.append(child.toString());
            strBuild.append(System.lineSeparator());
        }
        return strBuild.toString();
    }
}
