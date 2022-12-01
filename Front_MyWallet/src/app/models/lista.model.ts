import { Cartao } from "./cartao.model";
import { Carteira } from "./carteira.model";
import { Conta } from "./conta.model";
import { Usuario } from "./usuario.model";

interface Lista{
    id: number;
    conteudo: string;
    dinheiro: number;
    id_usuario: Usuario;
    id_conta: Conta;
    id_carteira: Carteira;
    id_cartao: Cartao;
}