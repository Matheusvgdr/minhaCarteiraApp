import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { ErrorHandler } from '../error.handler';
import { Carteira } from '../models/carteira.model';

@Injectable({
  providedIn: 'root'
})
export class CarteiraService {

  constructor(private http: HttpClient) { }

  postCadastrarCarteira(carterira: Carteira): Observable<Carteira>{
    return this.http.post<Carteira>(environment.UrlApiUsuario + `${"/cadastrarCarteira"}`, carterira).pipe(catchError(ErrorHandler.handleError));
  }

  postModificarCarteira(carteira: Carteira): Observable<Carteira>{
    return this.http.post<Carteira>(environment.UrlApiUsuario + `${"/modificarCarteira"}`, carteira).pipe(catchError(ErrorHandler.handleError));
  }

  getProcurarCarteira(idCarteira: number): Observable<Carteira>{
    return this.http.get<Carteira>(environment.UrlApiUsuario + `${"/procurarCarteira"}`, {params: new HttpParams().set("idCarteira", idCarteira)}).pipe(catchError(ErrorHandler.handleError));
  }

  getListarCarteiras(idUsuario: number): Observable<Carteira[]>{
    return this.http.get<Carteira[]>(environment.UrlApiUsuario + `${"/listarCarteiras"}`, {params: new HttpParams().set("idUsuario", idUsuario)}).pipe(catchError(ErrorHandler.handleError));
  }

  delDeletarCarteira(idCarteira: number): Observable<Carteira>{
    return this.http.delete<Carteira>(environment.UrlApiUsuario + `${"/deletarCarteira"}`, {params: new HttpParams().set("idCarteira", idCarteira)}).pipe(catchError(ErrorHandler.handleError));
  }

}
