
<h1>Informações do Desafio:</h1>

*   <h1>Bibliotecas Utilizadas:</h1>
    * Google Gson
        https://github.com/google/gson
    * Google Volley 
        https://android.googlesource.com/platform/frameworks/volley/
    * Google Android Support Library package
        *   Appcompat library v7:24.1.1
        *   Android Design Support Library 24.1.1
        *   Android Test Support Library - Espresso (spresso-core:2.2.2)
        *   RecyclerView Support Library - v7:24.1.1'
        *   CardView Support Library - v7: 24.1.1

Pontos observados no desenvolvimento do projeto:
    *   A mioria dos componentes necessitavam de adaptações. Sendo o maior desafio foi na busca de métodos e funções que garantissem a maior compatibilidade possível.
    *   Foi escolhida como minSdkVersion a API 12  pelo fato que dispositivos com a API>=12 representam cerca de 97.4% dos dispositivos que estão na Play Store.
    *   Foi escolhido utilizar o Volley para cache do JSON e imagens por aceitar algumas costumizações mais avançadas de que outra bibliotecas como o Picasso. Ou seja costumização da camada de transporte, na qual poderíamos estar utilizado a biblioteca OkHttp() 
    
    


