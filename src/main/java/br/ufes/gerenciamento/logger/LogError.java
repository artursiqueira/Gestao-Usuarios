package br.ufes.gerenciamento.logger;

import br.ufes.gerenciamento.model.Usuario;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LogError extends Log {
    private final String errorMessage;
    public LogError(Usuario usuarioAlvo, Usuario usuarioAutenticado, int operacao, String errorMessage) {
        super(usuarioAlvo, usuarioAutenticado, operacao);
        this.errorMessage = errorMessage;
        createMensagem();
    }
    @Override
    protected void createMensagem() {
        if(getUsuarioAlvo() == null && getUsuarioAutenticado() == null) {
            setMensagem(
                    "Ocorreu a falha " + getErrorMessage() + " ao realizar a " +
                            getOperacao() + ": Nao especificado,(" +
                            LocalDate.now().format(
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                            ) + ", " +
                            LocalTime.now().format(
                                    DateTimeFormatter.ofPattern("HH:mm")
                            ) + ", e Nao especificado)"
            );
        } else {
            setMensagem(
                    "Ocorreu a falha " + getErrorMessage() + " ao realizar a " +
                            getOperacao() + ": " + getUsuarioAlvo().getNome() + ",(" +
                            LocalDate.now().format(
                                    DateTimeFormatter.ofPattern("dd/MM/yyyy")
                            ) + ", " +
                            LocalTime.now().format(
                                    DateTimeFormatter.ofPattern("HH:mm")
                            ) + ", e " +
                            getUsuarioAutenticado().getUsuario() + ")"
            );
        }

    }
    private String getErrorMessage() {
        return this.errorMessage;
    }
}
