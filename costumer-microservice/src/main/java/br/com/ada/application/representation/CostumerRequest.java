package br.com.ada.application.representation;

import br.com.ada.domain.Costumer;

public class CostumerRequest {
    private String cpf;
    private String name;
    private Integer age;

    public Costumer toModel() {
        return new Costumer(cpf, name, age);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
