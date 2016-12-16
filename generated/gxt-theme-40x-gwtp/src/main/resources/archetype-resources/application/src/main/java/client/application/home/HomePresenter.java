#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;

import ${package}.client.application.ApplicationPresenter;
import ${package}.client.place.NameTokens;
import ${package}.client.place.ParameterTokens;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> implements HomeUiHandlers {

  interface MyView extends View, HasUiHandlers<HomeUiHandlers> {
  }

  @NameToken(NameTokens.Home)
  @ProxyStandard
  interface MyProxy extends ProxyPlace<HomePresenter> {
  }

  private PlaceManager placeManager;

  @Inject
  public HomePresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

    this.placeManager = placeManager;

    getView().setUiHandlers(this);
  }

  @Override
  public void onOpenWindow(String name) {
    displayWindow(name);
  }

  @Override
  public void onOpenGrid() {
    displayGrid();
  }

  private void displayGrid() {
    PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.Grid).build();
    placeManager.revealPlace(placeRequest);
  }

  private void displayWindow(String name) {
    PlaceRequest placeRequest = new PlaceRequest.Builder().nameToken(NameTokens.Window).with(ParameterTokens.name, name)
        .with(ParameterTokens.onHide, NameTokens.Home).build();
    placeManager.revealPlace(placeRequest);
  }

}
