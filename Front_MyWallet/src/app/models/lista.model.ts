import { Cartao } from "./cartao.model";
import { Carteira } from "./carteira.model";
import { Conta } from "./conta.model";

interface Lista{
    id: number;
    conteudo: string;
    dinheiro: number;
    id_conta: Conta;
    id_carteira: Carteira;
    id_cartao: Cartao;
}