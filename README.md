# VetCampo — Sistema de Gestão de Atendimentos Veterinários (Projeto Acadêmico)

[![UniRV](https://img.shields.io/badge/UniRV-Universidade%20de%20Rio%20Verde-red?style=for-the-badge)](#)
[![Disciplina](https://img.shields.io/badge/Disciplina-Programa%C3%A7%C3%A3o%20Orientada%20a%20Objetos-blue?style=for-the-badge)](#)
[![Atividade](https://img.shields.io/badge/Atividade-N1%20%E2%80%94%20Problema%20Aberto-orange?style=for-the-badge)](#)
[![Valor](https://img.shields.io/badge/Avalia%C3%A7%C3%A3o-70%20Pontos-brightgreen?style=for-the-badge)](#)
[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](#)
[![Status](https://img.shields.io/badge/Status-Conclu%C3%ADdo-brightgreen?style=for-the-badge)](#)

Este repositório contém o código do **VetCampo**, um sistema em Java
desenvolvido como atividade prática avaliativa da disciplina de
**Programação Orientada a Objetos (ESW448)**, do curso de **Engenharia de
Software** da **Universidade de Rio Verde (UniRV)**.

---

## 📌 Contexto Acadêmico

- **Instituição:** Universidade de Rio Verde (UniRV) — Campus Rio Verde
- **Curso:** Engenharia de Software
- **Disciplina:** Programação Orientada a Objetos (ESW448)
- **Atividade:** N1 — Problema Aberto (Clínica Veterinária VetCampo)
- **Conteúdo avaliado:** Classes e Objetos, Encapsulamento, Herança,
  Sobrecarga, Sobreposição, Interfaces e Classes Abstratas
- **Tipo:** Individual — código-fonte `.java` + vídeo de apresentação
- **Autor:** Luiz Felipe Rodrigues Ferreira

---

## 🎯 O Problema

A **VetCampo** é uma clínica veterinária de Rio Verde que atende animais de
estimação e animais de produção das fazendas da região. O cálculo de cada
atendimento era feito manualmente — calculadora e tabela impressa colada
no balcão — o que gerava erros de preço por quilo, esquecimento do
desconto de plano de saúde animal e falhas no controle das diárias de
internação, feito à mão em um caderno.

### 💡 O que o sistema resolve:
- **Cálculo automático da consulta:** cada espécie (cão, gato, bovino) tem
  sua própria fórmula de preço, aplicada sem intervenção manual.
- **Desconto de plano de saúde:** o valor com e sem plano é calculado a
  partir de uma única regra, sem duplicação de lógica no programa.
- **Controle de internações:** diárias acumuladas por animal, com valor
  total calculado automaticamente — sem depender de anotações em caderno.
- **Emissão de ficha:** qualquer animal atendido, de qualquer espécie,
  pode ter sua ficha impressa de forma padronizada.

---

## ✨ Requisitos do Enunciado Atendidos

| Requisito da Atividade | Implementação no VetCampo | Status |
| :--- | :--- | :---: |
| **Cadastro com/sem idade** | Construtores sobrecarregados em `Animal`, com idade padrão zero quando não informada | ✅ |
| **Peso alterável, demais dados fixos** | Único setter do sistema é `setPeso(double)`, com validação (`> 0`) | ✅ |
| **Cálculo por espécie** | `calcularValorConsulta()` abstrato, sobreposto por `Cao`, `Gato` e `Bovino` | ✅ |
| **Desconto de plano de saúde sem duplicar regra** | `calcularValorConsulta(boolean)` concreto em `Animal`, reaproveitando o cálculo de cada espécie | ✅ |
| **Internação (só cão e gato)** | Interface `Internavel`, implementada apenas por `Cao` e `Gato` | ✅ |
| **Ficha por espécie, sem repetir dados comuns** | `imprimirFicha()` sobreposto em cada espécie, reaproveitando `super.imprimirFicha()` | ✅ |
| **Nenhum "animal genérico"** | `Animal` é `abstract`, não pode ser instanciada diretamente | ✅ |
| **Listas polimórficas** | Vetor de `Animal` para todos os atendimentos e vetor de `Internavel` só para os internáveis | ✅ |

---

## 🛠️ Tecnologias e Conceitos Utilizados

- **Java (testado em JDK 25, Eclipse Temurin):** sem dependências
  externas, apenas biblioteca padrão (`java.util.ArrayList`, `List`).
- **Programação Orientada a Objetos:**
  - Encapsulamento — atributos privados em todas as classes.
  - Classe abstrata — `Animal`, com métodos abstratos e concretos.
  - Herança — `Cao`, `Gato` e `Bovino` reaproveitando `Animal` via `super(...)`.
  - Sobreposição (`@Override`) — cálculo de consulta e ficha por espécie.
  - Sobrecarga — construtor com/sem idade e consulta com/sem plano.
  - Interface — `Internavel`, contrato assinado só por quem pode internar.
  - Polimorfismo — vetores de `Animal` e de `Internavel` percorridos sem
    saber a espécie concreta de cada objeto.

---

## 📁 Estrutura de Arquivos

```text
vetcampo/
├── Animal.java              # Superclasse abstrata
├── Internavel.java          # Interface do contrato de internação
├── Cao.java                 # Espécie: cão
├── Gato.java                # Espécie: gato
├── Bovino.java              # Espécie: bovino
├── TesteVetCampo.java       # Classe de teste com o método main
├── Roteiro_Video_VetCampo.md # Roteiro de apoio para o vídeo de apresentação
└── README.md                 # Documentação do projeto
```

---

## ▶️ Como Compilar e Rodar

```bash
javac *.java
java TesteVetCampo
```

## ✅ Saída Esperada

| Valor | Resultado |
| :--- | :---: |
| Consulta do Thor (32 kg) | R$ 154,00 |
| Consulta do Thor com plano | R$ 123,20 |
| Consulta da Mel (5 kg) | R$ 87,50 |
| Consulta da Mel com plano | R$ 70,00 |
| Consulta da Estrela (480 kg) | R$ 534,00 |
| Consulta da Estrela com plano | R$ 427,20 |
| Internação do Thor (3 + 2 diárias) | 5 diárias — R$ 300,00 |
| Internação da Mel (4 diárias) | 4 diárias — R$ 180,00 |
| Consulta do Thor após pesagem de 35 kg | R$ 160,00 |

---

## 🐴 Desafio Opcional

O enunciado propõe acrescentar uma quarta espécie, **equino** — atendido
na fazenda como o bovino, porém internável, com diária de R$ 80,00 — como
teste de o quanto a modelagem em herança/interface se sustenta ao crescer.
