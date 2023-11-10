function [X,Y] = fn_smoothXY(xSalt, ySalt, windowSize)

  for i = 1:numel(ySalt)
    Y = movmean(ySalt, windowSize);
  endfor

  X = xSalt;

end


