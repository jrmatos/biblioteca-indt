
### Buscar todos os livros cadastrados

**GET**: /book/find/

Resultado:

```json
[
  {
    "id": "(number)",
    "title": "(String)",
    "author": "(String)",
    "publisher": "(String)",
    "year": "(number)",
    "pages": "(number)",
    "isbn": "(number)"
  }
]
```

### Buscar livros com paginação e filtro

**GET**: /book/find/{numeroDaPagina}?title=value&author=value&publisher=value&year=value&pages=value&isbn=value

Exemplo: /book/find/1?title=MasteringTaiJutsu&author=RockLee&publisher=Konoha&year=2008&pages=238&isbn=8974

Todos os parâmetros de filtro da query string são opcionais

Resultado:

```json
{
  "books": [
    {
      "id": "(number)",
      "title": "(string)",
      "author": "(string)",
      "publisher": "(string)",
      "year": "(number)",
      "pages": "(number)",
      "isbn": "(number)"
    }
  ],
  "page": "(number)",
  "pageSize": "(number)",
  "totalBooks": "(number)"
}
```

### Remover livro

**DELETE**: /book/{idDoLivro}

### Criar novo livro

**POST**: /book/

Envio:
```json
{
  "title": "(string)",
  "author": "(string)",
  "publisher": "(string)",
  "year": "(number)",
  "pages": "(number)",
  "isbn": "(number)"   
}
```

Resultado:
```json
{ 
  "id": "(number)",
  "title": "(string)",
  "author": "(string)",
  "publisher": "(string)",
  "year": "(number)",
  "pages": "(number)",
  "isbn": "(number)"    
}
```
### Atualizar livro

**PUT**: /book/

Envio:
```json
{
  "id": "(number)",
  "title": "(string)",
  "author": "(string)",
  "publisher": "(string)",
  "year": "(number)",
  "pages": "(number)",
  "isbn": "(number)"     
}
```

Resultado:
```json
{ 
  "id": "(number)",
  "title": "(string)",
  "author": "(string)",
  "publisher": "(string)",
  "year": "(number)",
  "pages": "(number)",
  "isbn": "(number)"    
}
```
