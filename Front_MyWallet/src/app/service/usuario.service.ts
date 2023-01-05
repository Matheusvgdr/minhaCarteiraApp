import { HttpClient, HttpParams } from '@angular/common/http';
import {  Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Usuario } from '../models/usuario.model';
import { ErrorHandler } from '../error.handler';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http: HttpClient) { }

  postCadastrarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(environment.UrlApiUsuario + `${"/cadastrarUsuario"}`, usuario)
    .pipe(catchError(ErrorHandler.handleError));
  }

  postModificarUsuario(usuario: Usuario): Observable<Usuario>{
    return this.http.post<Usuario>(environment.UrlApiUsuario + `${"/modificarUsuario"}`, usuario)
    .pipe(catchError(ErrorHandler.handleError));
  }

  getProcurarUsuario(idUsuario: number): Observable<Usuario>{
    return this.http.get<Usuario>(environment.UrlApiUsuario + `${"/procurarUsuario"}`, { params: new HttpParams().set("idUsuario", idUsuario)})
    .pipe(catchError(ErrorHandler.handleError));
  }

  getVerificarUsuario(nomeUsu: string, senha: string): Observable<Usuario>{
    return this.http.get<Usuario>(environment.UrlApiUsuario + `${"/verificarUsuario"}`, {params: new HttpParams().set("nomeUsuario", nomeUsu)
      .set("senha", senha)
    }).pipe(catchError(ErrorHandler.handleError));
  }

  delDeletarUsuario(idUsuario: number): Observable<Usuario>{
    return this.http.delete<Usuario>(environment.UrlApiUsuario + `${"/deletarUsuario"}`, {params: new HttpParams().set("idUsuario", idUsuario)
    }).pipe(catchError(ErrorHandler.handleError));
  }
  
}
