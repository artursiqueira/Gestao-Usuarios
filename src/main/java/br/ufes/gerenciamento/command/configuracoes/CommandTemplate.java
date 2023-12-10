package br.ufes.gerenciamento.command.configuracoes;

import br.ufes.gerenciamento.command.ICommand;
import br.ufes.gerenciamento.presenter.ConfiguracoesPresenter;
import br.ufes.gerenciamento.view.ConfiguracoesView;

public abstract class CommandTemplate implements ICommand {
    protected ConfiguracoesPresenter presenter;
    protected ConfiguracoesView view;

    public CommandTemplate(ConfiguracoesPresenter presenter) {
        this.presenter = presenter;
        this.view = presenter.getView();
    }
    public void onStart() {}
    public void onFinish() {}
    public void onError(Exception ex) {}
    public void onSuccess() {}
    @Override
    public abstract void executar();
}

