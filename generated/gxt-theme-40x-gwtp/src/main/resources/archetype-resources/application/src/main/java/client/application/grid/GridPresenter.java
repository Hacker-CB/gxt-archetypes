#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.client.application.grid;

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

public class GridPresenter extends Presenter<GridPresenter.MyView, GridPresenter.MyProxy> implements GridUiHandlers {

  interface MyView extends View, HasUiHandlers<GridUiHandlers> {
  }

  @NameToken(NameTokens.Grid)
  @ProxyStandard
  interface MyProxy extends ProxyPlace<GridPresenter> {
  }

  private PlaceManager placeManager;

  @Inject
  public GridPresenter(EventBus eventBus, MyView view, MyProxy proxy, PlaceManager placeManager) {
    super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);

    this.placeManager = placeManager;

    getView().setUiHandlers(this);
  }

}