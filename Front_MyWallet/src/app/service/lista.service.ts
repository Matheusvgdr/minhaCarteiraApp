import { HttpClient, HttpParams } from '@angular/common/http';
import { ErrorHandler } from '../error.handler';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Item} from '../models/lista.model';

@Injectable({
  providedIn: 'root'
})
export class ListaService {

  constructor(private http: HttpClient) { }

  // getProcurarItem(item: Item): Observable<Item>{
  //   return this.http.get<Item>(environment.UrlApiUsuario + `${"/procurarItem"}`, item).pipe(catchError(ErrorHandler.handleError));
  // }

  postCadastrarItem(item: Item): Observable<Item>{
    return this.http.post<Item>(environment.UrlApiUsuario + `${"/cadastrarItem"}`, item).pipe(catchError(ErrorHandler.handleError));
  }

  delDeletarItem(idItem: number): Observable<Item>{
    return this.http.delete<Item>(environment.UrlApiUsuario + `${"/deletarItem"}`, {params: new HttpParams().set("idItem", idItem)}).pipe(catchError(ErrorHandler.handleError));
  }

  postModificarItem(item: Item): Observable<Item>{
    return this.http.post<Item>(environment.UrlApiUsuario + `${"/modificarItem"}`, item).pipe(catchError(ErrorHandler.handleError));
  }

  getListarItens(idItem: number): Observable<Item[]>{
    return this.http.get<Item[]>(environment.UrlApiUsuario + `${"/listarItens"}`, {params: new HttpParams().set("idItem", idItem)}).pipe(catchError(ErrorHandler.handleError));
  }
    
    }
