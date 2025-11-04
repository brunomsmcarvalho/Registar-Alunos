document.addEventListener("DOMContentLoaded", () => {
  const btnsAdicionar = document.querySelectorAll(".btn-adicionar");
  const btnsRemover = document.querySelectorAll(".btn-remover");

   btnsAdicionar.forEach(btn => {
      btn.addEventListener("click", (event) => {
        const confirmacao = confirm("Tens a certeza que deseja adicionar este aluno?");
        if(!confirmacao){
          event.preventDefault();
        }
      });
    });

  btnsRemover.forEach(btn => {
    btn.addEventListener("click", (event) => {
      const confirmacao = confirm("Tem a certeza que deseja remover este aluno?");
      if(!confirmacao){
        event.preventDefault();
      }
    });
  });

  console.log("Script JS carregado com sucesso!");
});