function [] = fn_plotSaltSmooth()
  [plotX,plotY] = fn_plotXY(-50, 50);
  [saltX,saltY] = fn_saltXY(plotX, plotY);
  [smoothX,smoothY] = fn_smoothXY(saltX, saltY, 25);

  csvwrite("plotData.csv", [plotX', plotY']);
  csvwrite("saltData.csv", [saltX', saltY']);
  csvwrite("smoothData.csv", [smoothX', smoothY']);

  plot(plotX, plotY);
  legend("Plot Data")
  hold on;
  plot(saltX, saltY, "displayname", "Salt Data");
  hold on;
  plot(smoothX, smoothY, "displayname", "Smooth Data");

end
