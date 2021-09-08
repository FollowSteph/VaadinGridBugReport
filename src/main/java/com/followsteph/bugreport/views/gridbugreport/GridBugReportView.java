package com.followsteph.bugreport.views.gridbugreport;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridSortOrder;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.provider.SortDirection;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.PageTitle;

import java.util.List;

@PageTitle("GridBugReport")
@Route(value = "")
public class GridBugReportView extends HorizontalLayout {

    public GridBugReportView() {
        addClassName("grid-bug-report-view");

        Grid<Car> grid = new Grid<>();

        grid.addColumn(Car::getName)
                .setSortable(true)
                .setComparator(Car::getName)
                .setKey("Name")
                .setHeader("Name");
        grid.addColumn(Car::getDescription)
                .setSortable(true)
                .setComparator(Car::getDescription)
                .setKey("Price")
                .setHeader("Price");
        grid.addColumn(Car::getPrice)
                .setSortable(true)
                .setComparator(Car::getPrice)
                .setKey("Description")
                .setHeader("Description");

        grid.setItems(DataGenerator.getListOfCars());

        grid.setMultiSort(true);

        grid.addSortListener(event -> {
            System.out.println("grid: " + grid.getSortOrder().size() + " : " + event.isFromClient());
            System.out.println("event: " + event.getSortOrder().size() + " : " + event.isFromClient());
        });

        defaultSort(grid);

        Button resetButton = new Button("Reset", click -> {
            System.out.println("grid: " + grid.getSortOrder().size());
            defaultSort(grid);
            grid.setColumnOrder(
                    grid.getColumnByKey("Name"),
                    grid.getColumnByKey("Price"),
                    grid.getColumnByKey("Description"));
        });

        add(grid, resetButton);
    }

    private void defaultSort(Grid grid) {
        System.out.println("Reset");
        grid.sort(List.of(
                new GridSortOrder<>(grid.getColumnByKey("Name"), SortDirection.ASCENDING),
                new GridSortOrder<>(grid.getColumnByKey("Price"), SortDirection.ASCENDING)
        ));
    }
}
