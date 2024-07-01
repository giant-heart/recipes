import React from 'react';
export type CFontProps = {
    font: 'block' | 'slick' | 'tiny' | 'grid' | 'pallet' | 'shade' | 'simple' | 'simpleBlock' | '3d' | 'simple3d' | 'chrome' | 'huge';
    align: 'left' | 'center' | 'right';
    colors: string[];
    backgroundColor: 'transparent' | 'black' | 'red' | 'green' | 'yellow' | 'blue' | 'magenta' | 'cyan' | 'white';
    letterSpacing: number;
    lineHeight: number;
    space: boolean;
    maxLength: number;
};
export type BigTextProps = {
    text: string;
} & Partial<CFontProps>;
declare const BigText: React.FC<BigTextProps>;
export default BigText;
