package net.osmand.plus.server.map;

import android.graphics.Canvas;
import net.osmand.data.RotatedTileBox;
import net.osmand.map.ITileSource;
import net.osmand.map.TileSourceManager;
import net.osmand.plus.OsmandApplication;
import net.osmand.plus.render.MapVectorLayer;
import net.osmand.plus.routing.RoutingHelper;
import net.osmand.plus.views.MapTileLayer;
import net.osmand.plus.views.layers.FavouritesLayer;
import net.osmand.plus.views.layers.GPXLayer;
import net.osmand.plus.views.layers.MapTextLayer;
import net.osmand.plus.views.layers.RouteLayer;

public class LayersDraw {
    public static void createLayers(OsmandApplication app, Canvas canvas, final OsmandMapTileMiniView mapView) {
        RoutingHelper routingHelper = app.getRoutingHelper();
        // first create to make accessible
        MapTextLayer mapTextLayer = new MapTextLayer();
        // 5.95 all labels
        //mapView.addLayer(mapTextLayer, 5.95f);
        // 8. context menu layer
        //ContextMenuLayer contextMenuLayer = new ContextMenuLayer(app);
        //mapView.addLayer(contextMenuLayer, 8);
        // mapView.addLayer(underlayLayer, -0.5f);
        RotatedTileBox currentTileBlock = mapView.getCurrentRotatedTileBox();
//        RotatedTileBox currentTileBlock = new RotatedTileBox.RotatedTileBoxBuilder()
//                .setLocation(50.901430, 34.801775)
//                .setZoom(15)
//                .setPixelDimensions(canvas.getWidth(), canvas.getHeight(), 0.5f, 0.5f).build();

        MapTileMiniLayer mapTileLayer = new MapTileMiniLayer(true);
        mapView.addLayer(mapTileLayer, 0.0f);

        ITileSource map = TileSourceManager.getMapillaryVectorSource();
        mapTileLayer.setMap(map);
        mapTileLayer.drawTileMap(canvas,currentTileBlock);
        //mapView.setMainLayer(mapTileLayer);
        // 0.5 layer
        MapVectorMiniLayer mapVectorLayer = new MapVectorMiniLayer(mapTileLayer, false);
        mapView.addLayer(mapVectorLayer, 0.5f);
//        mapVectorLayer.onPrepareBufferImage(canvas,
//                currentTileBlock,
//                new OsmandMapMiniLayer.DrawSettings(false));
        //DownloadedRegionsLayer downloadedRegionsLayer = new DownloadedRegionsLayer(activity);
        //mapView.addLayer(downloadedRegionsLayer, 0.5f);

        // 0.9 gpx layer
        GPXLayer gpxLayer = new GPXLayer();
        //mapView.addLayer(gpxLayer, 0.9f);

        // 1. route layer
        RouteLayer routeLayer = new RouteLayer(routingHelper);
        //mapView.addLayer(routeLayer, 1);

        // 2. osm bugs layer
        // 3. poi layer
        POIMapLayerMini poiMapLayer = new POIMapLayerMini(app);
        mapView.addLayer(poiMapLayer, 3);

        poiMapLayer.onPrepareBufferImage(canvas, currentTileBlock,
                new OsmandMapMiniLayer.DrawSettings(false));
        // 4. favorites layer
        FavouritesLayer mFavouritesLayer = new FavouritesLayer();
        //mapView.addLayer(mFavouritesLayer, 4);
        // 4.6 measurement tool layer
        //MeasurementToolLayer measurementToolLayer = new MeasurementToolLayer();
        //mapView.addLayer(measurementToolLayer, 4.6f);
        // 5. transport layer
        //TransportStopsLayer transportStopsLayer = new TransportStopsLayer(activity);
        //mapView.addLayer(transportStopsLayer, 5);
        // 5.95 all text labels
        // 6. point location layer
        //PointLocationLayer locationLayer = new PointLocationLayer(activity.getMapViewTrackingUtilities());
        //mapView.addLayer(locationLayer, 6);
        // 7. point navigation layer
        //PointNavigationLayer navigationLayer = new PointNavigationLayer(activity);
        //mapView.addLayer(navigationLayer, 7);
        // 7.3 map markers layer
        //MapMarkersMiniLayer mapMarkersLayer = new MapMarkersMiniLayer(app);
        //mapView.addLayer(mapMarkersLayer, 7.3f);
        //MyCustomLayer layer = new MyCustomLayer();
        //mapView.addLayer(layer,2);

        // 7.5 Impassible roads
        //ImpassableRoadsLayer impassableRoadsLayer = new ImpassableRoadsLayer(activity);
        //mapView.addLayer(impassableRoadsLayer, 7.5f);
        // 7.8 ruler control layer
        //RulerControlLayer rulerControlLayer = new RulerControlLayer(activity);
        //mapView.addLayer(rulerControlLayer, 7.8f);
        // 8. context menu layer
        // 9. map info layer
        //MapInfoLayer mapInfoLayer = new MapInfoLayer(activity, routeLayer);
        //mapView.addLayer(mapInfoLayer, 9);
        // 11. route info layer
        //MapControlsLayer mapControlsLayer = new MapControlsLayer(activity);
        //mapView.addLayer(mapControlsLayer, 11);
        // 12. quick actions layer
        //MapQuickActionLayer mapQuickActionLayer = new MapQuickActionLayer(activity, contextMenuLayer);
        //mapView.addLayer(mapQuickActionLayer, 12);
        //contextMenuLayer.setMapQuickActionLayer(mapQuickActionLayer);
        //mapControlsLayer.setMapQuickActionLayer(mapQuickActionLayer);

//        StateChangedListener transparencyListener = new StateChangedListener<Integer>() {
//            @Override
//            public void stateChanged(Integer change) {
//                mapTileLayer.setAlpha(change);
//                mapVectorLayer.setAlpha(change);
//                mapView.refreshMap();
//            }
//        };
       // app.getSettings().MAP_TRANSPARENCY.addListener(transparencyListener);


        //OsmandPlugin.createLayers(mapView, activity);
        //app.getAppCustomization().createLayers(mapView, activity);
        //app.getAidlApi().registerMapLayers(activity);

        //return OsmandPlugin.createLayers(mapView, app);
        //app.getAppCustomization().createLayers(mapView, activity);
        //app.getAidlApi().registerMapLayers(activity);
    }
}
