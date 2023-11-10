function [X,Y] = fn_saltXY(xPlot, yPlot)

  for i = 1:numel(yPlot)
    randNum = randi([-50,50]);
    Y(i) = yPlot(i) + randNum;
  endfor

  X = xPlot;

end

