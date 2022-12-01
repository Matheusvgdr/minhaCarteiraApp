import { Cartao } from "./cartao.model";
import { Conta } from "./conta.model";
import { Usuario } from "./usuario.model";

export {Carteira}

interface Carteira{
    id: number;
    nomeCarteira: string;
    dinheiro: number;
    id_usuario: Usuario;
    id_conta: Conta;
    id_cartao?: Cartao;
}