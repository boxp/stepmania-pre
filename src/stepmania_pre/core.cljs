(ns stepmania-pre.core 
  (:require [goog.graphics :as Graphics]))

; 初期化＆丸を描画
(defn initcircle []
  (let [graphics (Graphics/createGraphics 512 512) ; 描画領域の初期化
        initialstroke (Graphics/Stroke. 2,"#000000") ; 線の生成
        initialfill (Graphics/SolidFill. "#ffff00")] ; 塗りつぶしの生成
    ; 丸の描画
    (doto graphics
      (.drawCircle 200 200 100 initialstroke initialfill)
      (.render js/circlecanvas))))

(set! (. js/window -onload) initcircle)
