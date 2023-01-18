import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { __param } from 'tslib';
import { ErrorHandler } from '../error.handler';
import { Movi } from '../models/movimentacao.model';

@Injectable({
  providedIn: 'root'
})
export class MovimentacaoService {

  constructor(private http: HttpClient) { }

  postRealizarTransacao(movimentacao: Movi): Observable<Movi>{
    return this.http.post<Movi>(environment.UrlApiUsuario + `${"/realizarTransacao"}`, movimentacao).pipe(catchError(ErrorHandler.handleError)); 
  }

  getListarSaques(idMovimentacao: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiUsuario + `${"/listarSaques"}`, {params: new HttpParams().set("idMovimentacao", idMovimentacao)}).pipe(catchError(ErrorHandler.handleError));
  }

  getListarDepositos(idMovimentacao: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiUsuario + `${"/listarDepositos"}`, {params: new HttpParams().set("idMovimentacao", idMovimentacao)}).pipe(catchError(ErrorHandler.handleError));
  }

  getListarMovimentacao(idMovimentacao: number): Observable<Movi[]>{
    return this.http.get<Movi[]>(environment.UrlApiUsuario + `${"listarMovimentacao"}`, {params: new HttpParams().set("idMovimentacao", idMovimentacao)}).pipe(catchError(ErrorHandler.handleError));
  }

  postRealizarTransacaoCarteira(movimentacao: Movi): Observable<Movi>{
    return this.http.post<Movi>(environment.UrlApiUsuario + `${"/realizarTransacaoCarteira"}`, movimentacao).pipe(catchError(ErrorHandler.handleError)); 
  }
}