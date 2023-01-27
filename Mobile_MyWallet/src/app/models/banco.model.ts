import { Usuario } from "./usuario.model";

export {Banco}

interface Banco{
    id?: number;
    banco: string;
    id_usuario: Usuario;
}