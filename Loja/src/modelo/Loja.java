/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;
import java.time.LocalDate;
/**
 *
 * @author User
 */
public class Loja {
    private Integer codigo;
    private String nome;
    private Integer nrfuncionarios;
    private LocalDate data;
    private Double valorbolsa;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNrfuncionarios() {
        return nrfuncionarios;
    }

    public void setNrfuncionarios(Integer nrfuncionarios) {
        this.nrfuncionarios = nrfuncionarios;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Double getValorbolsa() {
        return valorbolsa;
    }

    public void setValorbolsa(Double valorbolsa) {
        this.valorbolsa = valorbolsa;
    }

    @Override
    public String toString() {
        return "Loja{" + "nome=" + nome + '}';
    }
    
}
