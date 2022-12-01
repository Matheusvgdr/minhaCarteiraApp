import { Usuario } from "./usuario.model";

export {Conta};

interface Conta{
    id: number;
    nomeUsuario: string;
    senha: string;
    id_usuario: Usuario;
}