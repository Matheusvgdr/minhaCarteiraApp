import { Cartao } from "./cartao.model";
import { Conta } from "./conta.model";

export {Carteira}

interface Carteira{
    id: number;
    nomeCarteira: string;
    dinheiro: number;
    id_conta: Conta;
    id_cartao?: Cartao;
}